$(init);

function init() {
  var dropdown = $(".nav-bar-dropdown p");
  dropdown.click(function () {
    var selected = $(this).text();

    var consoleContent = $(".console-statement-content");
    var consoleSyntaxInput =
      '<p style="text-align: left;">console.log(<input type="text" class="var-console-name-input" id="console-var-name" placeholder="var name">)</p>';

    var varContent = $(".var-content");
    var varSyntaxInput =
      '<p style="text-align: left;">var <input type="text" class="var-syntax-name-input" id="var-name" placeholder="name"> = <input type="text" class="var-syntax-input" id="var-string" placeholder="msg"></p>';

    if (!dropdown) return;

    if (selected == "Block Code") {
      consoleContent.html("Outputs a message to the web console");
      varContent.html(
        "A way to easily store data with a semantic name of your choosing"
      );
    } else if (selected == "Syntax") {
      consoleContent.html(consoleSyntaxInput);
      varContent.html(varSyntaxInput);
    } else return;
  });
}
