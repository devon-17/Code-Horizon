function test(option) {

    var if_text = document.getElementById('if_statement_content');
    var if_code_block = "when x happens something else happens";
    var if_syntax = "if (x) { y; }"
    

    var selected = (option.options[option.selectedIndex].text);
    // alert("You Chose: " + selected);


    /*
    const custom_style={
        display: 'show',
        color: "green"
    }
    */

    
    // change to proper text
    if (selected == "< Syntax Highlighting />") {
        if_text.innerHTML = if_syntax;
    } else if (selected == "< Block Code />") {
        if_text.innerHTML = if_code_block;
    }
}