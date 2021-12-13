function changeCodeType(option) {

    var if_text = document.getElementById('ifStatementContent');
    var selected = (option.options[option.selectedIndex].text);
    // alert("You Chose: " + selected);


    /*
    const custom_style={
        display: 'show',
        color: "green"
    }
    */

    var if_code_block = "when x happens something else happens";
    var if_syntax = "if (x) { y; }";
    
    // change to proper text
    if (selected == "< Syntax />") {
        if_text.innerHTML = if_syntax;
    } else if (selected == "< Block Code />") {
        if_text.innerHTML = if_code_block;
    }
}