$(init);

function init() {
  var dropdown = $("#dropdown li");
  dropdown.click(function () {
    var selText = $(this).text();
    // $("#tableButton").text(selText); //Using Jquery

    var ifStatementContent = $(".if-statement-content");
    var ifStatementInput = $(".if-statement-input");

    var variablesContent = $(".variables-content");

    var forLoopContent = $(".for-loop-content");

    if (!dropdown) return;

    if (selText == "Block Code") {
      ifStatementInput.text(selText);
    } else if (selText == "Syntax") {
      ifStatementContent.text("if(x) { logic }");
      variablesContent.text('var name = "Name";');
      forLoopContent.text("for(var i = 0; i < 10; i++) { logic }");
    }
  });
}
