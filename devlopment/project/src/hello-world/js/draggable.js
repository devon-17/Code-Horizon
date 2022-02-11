$(init);
function init() {
  var diagram = [];
  var canvas = $(".canvas");

  $(".inventory-element").draggable({
    helper: "clone",
  });
  canvas.droppable({
    drop: function (event, ui) {
      var node = {
        _id: new Date().getTime(),
        position: ui.helper.position(),
      };
      node.position.left -= canvas.position().left;
      if (ui.helper.hasClass("element-1")) {
        node.type = "ELEMENT-1";
      } else if (ui.helper.hasClass("element-2")) {
        node.type = "ELEMENT-2";
      } else {
        return;
      }
      diagram.push(node);
      renderDiagram(diagram);
    },
  });
  function renderDiagram(diagram) {
    var canvasTitle = "<h3 class='title-text'>Code Canvas: </h3>";
    var console =
      '<div class="console">' +
      '<h2 class="title-text">Console</h2>' +
      '<button type="button" class="btn btn-outline-success console-run-btn" onclick="getInputValue();">Run Code</button>' +
      "</div>";

    canvas.empty();
    canvas.append(canvasTitle);
    canvas.append(console);

    for (var d in diagram) {
      var node = diagram[d];

      var consoleLog =
        '<div class="card moveable-element" style="width: 18rem; min-height: 10rem;">' +
        '<div class="card-body">' +
        '<h5 class="card-title">console.log();</h5>' +
        '<p class="card-text console-statement-content" style="text-align: left;">' +
        'console.log(<input type="text" class="var-console-name-input" id="console-var-name" placeholder="var name">)' +
        "</p>" +
        '<a href="https://developer.mozilla.org/en-US/docs/Web/API/Console/log" target="_blank"' +
        'class="btn btn-outline-dark">More Info</a>' +
        "</div>";
      ("</div>");

      var variable =
        '<div class="card moveable-element" style="width: 18rem; min-height: 10rem;">' +
        '<div class="card-body">' +
        '<h5 class="card-title">VARIABLES</h5>' +
        '<p class="card-text var-content" style="text-align: left;">' +
        'var <input type="text" class="var-syntax-name-input" id="var-name"' +
        'placeholder="name"> = <input type="text" class="var-syntax-input" id="var-string" placeholder="msg">' +
        "</p>" +
        '<a href="https://launchschool.com/books/ruby/read/variables" target="_blank"' +
        'class="btn btn-outline-dark">More Info</a>' +
        "</div>";
      ("</div>");

      // var variables =
      //   '<div class="moveable-element">' +
      //   '<div class="moveable-element-header purple">VARIABLES</div>' +
      //   '<p class="variables-content">A way to easily store data with a semantic name of your choosing</p>' +
      //   "</div>";

      var html = "";
      if (node.type === "ELEMENT-1") {
        html = consoleLog;
      } else if (node.type === "ELEMENT-2") {
        html = variable;
      }
      var dom = $(html)
        .css({
          position: "absolute",
          top: node.position.top,
          left: node.position.left,
        })
        .draggable({
          stop: function (event, ui) {
            console.log(ui);
            var id = ui.helper.attr("id");
            for (var i in diagram) {
              if (diagram[i]._id == id) {
                diagram[i].position.top = ui.position.top;
                diagram[i].position.left = ui.position.left;
              }
            }
          },
        })
        .attr("id", node._id);
      canvas.append(dom);
    }
  }
}
