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

  alert(consoleOutput.length);

  var consoleOutputMsg = varString;
  var index = consoleOutput.length;

  while (index <= 2) {
    if (varName && consoleVarName != "") {
      // Displaying the value
      if (varName == consoleVarName) {
        consoleOutput.append(consoleOutputMsg);
        index++;
      } else {
        alert("There is an error somewhere; Check var names");
      }
    } else {
      alert("Put names and strings into slots");
    }
  }
  console.log(consoleOutput.length);
}
