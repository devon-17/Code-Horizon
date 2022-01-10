$(init);

function init() {
  var diagram = [];
  var canvas = $(".canvas"); // getting canvas element
  var inventory = $(".inventory");

  // making element in DOM moveable
  $(".moveable-element").draggable({
    // cloning the element
    helper: "clone",
  });
  canvas.droppable({
    drop: function (event, ui) {
      var node = {
        _id: new Date().getTime(),
      };

      node.position.left -= tools.width();
      if (ui.helper.hasClass("element-1")) {
        node.type = "ELEMENT-1";
      } else if (ui.helper.hasClass("element-2")) {
        node.type = "ELEMENT-2";
      } else if (ui.helper.hasClass("element-3")) {
        node.type = "ELEMENT-3";
      }
      diagram.push(node);
      renderDiagram(diagram);
    },
  });

  function renderDiagram(diagram) {
    canvas.empty();

    var elementOne = $(".element-1");
    var elementTwo = $(".element-2");
    var elementThree = $(".element-3");

    for (var d in diagram) {
      var node = diagram[d];

      var html = "";

      if (node.type === "ELEMENT-1") {
        html = elementOne;
      } else if (node.type === "ELEMENT-2") {
        html = elementTwo;
      } else if (node.type === "ELEMENT-3") {
        html = elementThree;
      }

      // setting it properly in position on screen
      var dom = $(html)
        .css({
          "position": "absolute",
          "top": node.position.top,
          "left": node.position.left,
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
