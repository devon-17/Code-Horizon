$(init);

function init() {
  var dropdown = $(".nav-bar-dropdown p");
  dropdown.click(function () {
    var selected = $(this).text();
    // $("#tableButton").text(selText); //Using Jquery

    var ifStatementContent = $(".if-statement-content");

    var variablesContent = $(".variables-content");

    var forLoopContent = $(".for-loop-content");

    if (!dropdown) return;

    if (selected == "Block Code") {
      ifStatementContent.text(
        "if something happens then something else happens"
      );
      variablesContent.text(
        "A way to easily store data with a semantic name of your choosing"
      );
      forLoopContent.text("A way to easily specify and control iteration");
    } else if (selected == "Syntax") {
      ifStatementContent.text("if(x) { logic }");
      variablesContent.text('var name = "Name";');
      forLoopContent.text("for(var i = 0; i < 10; i++) { logic }");
    } else return;
  });
}
