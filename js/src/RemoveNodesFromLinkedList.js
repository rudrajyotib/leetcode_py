//https://leetcode.com/problems/remove-nodes-from-linked-list/description/

const { ListNode } = require("./util/ListNode");

var removeNodes = function(head) {

    if (head.next === null){
        return head
    }


    const stack = []

    let pointer = head

    while(pointer){
        
        if (stack.length === 0){
            stack.push([pointer.val,1])
        }else{
            removeSmallerElementsInStack(stack, pointer.val)
        }
        pointer = pointer.next
    }

    let resultHead = new ListNode(stack[0][0])
    let resultPointer = resultHead

    for (let repeatCounter = 2;repeatCounter<=stack[0][1];repeatCounter++){
        resultPointer.next = new ListNode(stack[0][0])
        resultPointer = resultPointer.next
    }

    for (let counter = 1; counter<stack.length; counter++){
        for (let repeatCounter = 1;repeatCounter<=stack[counter][1];repeatCounter++){
            resultPointer.next = new ListNode(stack[counter][0])
            resultPointer = resultPointer.next
        }
    }

    return resultHead

};


const removeSmallerElementsInStack = (stack, reference) => {
    
    while(stack.length > 0 ){
        let element = stack.pop()
        if (element[0] > reference){
            stack.push(element)
            stack.push([reference,1])
            return
        }else if (element[0] === reference){
            stack.push([element[0], element[1]+1])
            return
        }
    }
    if (stack.length === 0){
        stack.push([reference, 1])
    }
}

module.exports = {removeNodes}