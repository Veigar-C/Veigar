/**
 * Created by Administrator on 2018/3/23.
 */
function complain() {
    var code = document.getElementsByName('select');
    check_val = [];
    var i;
    for(i=0;i<code.length;i++){
        if(code[i].checked)
            check_val.push(code[i].value);
    }
    window.location.href = "toCRForm?code="+check_val;
}