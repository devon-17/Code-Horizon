// $(document).ready(function () {
//   // Get value on button click and show alert
//   $("#console-btn").click(function () {
//     var str = $(".var-syntax-name-input").attr("value");
//     alert(str);
//   });
// });

function getInputValue() {
  // Selecting the input element and get its value
  var varName = document.getElementById("var-name").value;

  // Displaying the value
  alert(varName);
}
