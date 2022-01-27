// $(document).ready(function () {
//   // Get value on button click and show alert
//   $("#console-btn").click(function () {
//     var str = $(".var-syntax-name-input").attr("value");
//     alert(str);
//   });
// });

function getInputValue() {
  var console = $(".console");
  // const console = document.getElementsByClassName("console");

  // Selecting the input element and get its value
  var varName = document.getElementById("var-name").value;
  var varString = document.getElementById("var-string").value;
  var consoleVarName = document.getElementById("console-var-name").value;

  if (console.length <= 1) {
    // Displaying the value
    if (varName == consoleVarName) {
      console.append("Object: " + varString);
      alert(console.length);
    } else {
      alert("There is an error somewhere");
    }
  }
}
