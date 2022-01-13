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
      } else if (ui.helper.hasClass("element-3")) {
        node.type = "ELEMENT-3";
      } else {
        return;
      }
      diagram.push(node);
      renderDiagram(diagram);
    },
  });
  function renderDiagram(diagram) {
    canvas.empty();
    canvas.append("<h2>Code Canvas</h2>");

    for (var d in diagram) {
      var node = diagram[d];

      var ifStatement =
        '<div class="moveable-element">' +
        '<div class="moveable-element-header orange">IF STATEMENT</div>' +
        '<p class="if-statement-content">when <span class="if-statement-input">x</span> happens something else happens</p>' +
        "</div>";

      var variables =
        '<div class="moveable-element">' +
        '<div class="moveable-element-header purple">VARIABLES</div>' +
        '<p class="variables-content">a way to easily store data with a semantic name of youre choosing</p>' +
        "</div>";

      var forLoops =
        '<div class="moveable-element">' +
        '<div class="moveable-element-header red-pink">FOR LOOPS</div>' +
        '<p class="for-loop-content">easy flowing way to control and specify iteration</p>' +
        "</div>";

      var html = "";
      if (node.type === "ELEMENT-1") {
        html = ifStatement;
      } else if (node.type === "ELEMENT-2") {
        html = variables;
      } else if (node.type === "ELEMENT-3") {
        html = forLoops;
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
