//https://leetcode.com/problems/remove-linked-list-elements/description/

const {ListNode}  = require("./util/ListNode")

/*
* @param {ListNode} head
* @param {number} val
* @return {ListNode}
*/
var removeElements = function (head, val) {
    if (head === null){
        return null
    }
    if (head.next === null && head.val === val){
        return null
    }
    let resultHead = null
    let pointerHead = head
    let resultPointer
    while(pointerHead){
        if (pointerHead.val !== val){
            if (resultHead){
                resultPointer.next = pointerHead
                resultPointer = resultPointer.next
            }else{
                resultHead = pointerHead
                resultPointer = resultHead
            }
        }else{
            if (resultPointer){
                resultPointer.next = null
            }
        }
        pointerHead = pointerHead.next
    }
    return resultHead
    
};

module.exports = { removeElements }