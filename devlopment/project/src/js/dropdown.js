$(init);

function init() {
  $("#dropdown li").click(function () {
    var selText = $(this).text();
    // $("#tableButton").text(selText); //Using Jquery

    var ifStatementContent = $(".if-statement-content");
    var ifStatementInput = $(".if-statement-input");

    if (selText == "Block Code") {
      ifStatementInput.text(selText);
    } else if (selText == "Syntax") {
      ifStatementContent.text("if(x) { logic }");
    }
  });
}
