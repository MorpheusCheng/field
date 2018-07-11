/**
 * Created by hello on 2018/3/19.
 */

window.addEventListener('load', function () {
    document.getElementById("bth-search").disabled = true;
    moveCode();
})
//获取元素距离页面边缘的距离


function getOffset(box, direction) {

    var setDirection = (direction == 'top') ? 'offsetTop' : 'offsetLeft';
    var offset = box[setDirection];

    var parentBox = box.offsetParent;

    while (parentBox) {
        offset += parentBox[setDirection];
        parentBox = parentBox.offsetParent;
    }
    parentBox = null;
    return parseInt(offset);
}

function moveCode() {

    //获取第一个#codebox元素
    var box = document.querySelector("#code-box"),
        progress = box.querySelector("p"),
        codeInput = box.querySelector('.code-input'),
        evenBox = box.querySelector("span");


    //鼠标按下，鼠标移动，鼠标释放
    var boxEven = ['mousedown', 'mousemove', 'mouseup'];

    var goX, offsetLeft, deviation, evenWidth, endX;

    function moveFn(e) {
        e.preventDefault();
        e = (boxEven['0'] == 'touchstart') ? e.touches[0] : e || window.event;

        endX = e.clientX - goX;
        endX = (endX > 0) ? (endX > evenWidth) ? evenWidth : endX : 0;

        if (endX > evenWidth * 0.7) {

            progress.innerText = '松开验证';
            progress.style.backgroundColor = "#66CC66";
        } else {

            progress.innerText = '';
            progress.style.backgroundColor = "#FFFF99";
        }

        progress.style.width = endX + deviation + 'px';
        evenBox.style.left = endX + 'px';

    }

    function removeFn() {
        document.removeEventListener(boxEven['2'], removeFn, false);
        document.removeEventListener(boxEven['1'], moveFn, false);

        if (endX > evenWidth * 0.7) {
            progress.innerText = '验证成功';
            //验证成功按钮启用
            document.getElementById("bth-search").disabled = false;
            progress.style.width = evenWidth + deviation + 'px';
            evenBox.style.left = evenWidth + 'px'
            evenBox.onmousedown = null;
            evenBox.onmousemove = null;
            evenBox.onmouseout = null;
        } else {
            progress.style.width = '0px';
            evenBox.style.left = '0px';
        }
    }

    evenBox.addEventListener(boxEven['0'], function (e) {
        e = (boxEven['0'] == 'touchstart') ? e.touches[0] : e || window.event;
        goX = e.clientX,
            offsetLeft = getOffset(box, 'left'),
            deviation = this.clientWidth,
            evenWidth = box.clientWidth - deviation,
            endX;
        document.getElementById("bth-search").disabled = true;

        document.addEventListener(boxEven['1'], moveFn, false);
        document.addEventListener(boxEven['2'], removeFn, false);

    }, false);
}
