var if_text = document.getElementById("ifStatementContent");
var variables_text = document.getElementById("variablesContent");

var ifCodeBlockText = "when happens x something else happens";
var ifSyntaxText = "if (x) { y; }";
var variablesCodeBlockText = "Way to store information in different data types";
var variablesSyntaxText = "var x = 5;";

var codeBlockChoice = document.getElementById("block_choice");
var syntaxChoice = document.getElementById("syntax_choice");
var blockText = codeBlockChoice.innerText;
var syntaxText = syntaxChoice.innerText;

function changeCodeType(option) {
  checkInput();

  var selected = option.options[option.selectedIndex].text;
  // change to proper text
  if (selected == blockText) {
    if_text.innerHTML = ifCodeBlockText;
    variables_text.innerHTML = variablesCodeBlockText;
  } else if (selected == syntaxText) {
    if_text.innerHTML = ifSyntaxText;
    variables_text.innerHTML = variablesSyntaxText;
  }
}

function checkInput() {
  var inputA = document.getElementById("input_a").value;
  ifCodeBlockText = "when " + inputA + " happens something else happens";
  ifSyntaxText = "if (" + inputA + ") { y; }";

  if (inputA == 2) {
    alert("ENTERED TWO");
  }
}
