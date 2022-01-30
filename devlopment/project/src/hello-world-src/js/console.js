// $(document).ready(function () {
//   // Get value on button click and show alert
//   $("#console-btn").click(function () {
//     var str = $(".var-syntax-name-input").attr("value");
//     alert(str);
//   });
// });

function getInputValue() {
  var consoleOutput = $(".console");
  // const console = document.getElementsByClassName("console");

  // Selecting the input element and get its value
  var varName = document.getElementById("var-name").value;
  var varString = document.getElementById("var-string").value;
  var consoleVarName = document.getElementById("console-var-name").value;

  var consoleOutputMsg = varString + "<br>";
  var index = 0;

  if (varName && consoleVarName != "") {
    // Displaying the value
    if (varName == consoleVarName) {
      consoleOutput.append("Object: " + consoleOutputMsg);
      index += 1;
    } else {
      alert("There is an error somewhere, Check var names");
    }
  } else {
    alert("Please fill in fields");
  }
  console.log(index);
}
