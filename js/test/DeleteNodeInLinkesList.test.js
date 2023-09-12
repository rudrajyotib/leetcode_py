const { expect } = require("chai");
const { describe } = require("mocha");
const { deleteNode } = require("../src/DeleteNodeInLinkedList");
const { ListNode } = require("../src/util/ListNode");

describe('should delete node', ()=>{
    it('should delete node', ()=>{
        var nodeToDelete = new ListNode(1)
        var head = new ListNode(2)
        head.next = new ListNode(3)
        head.next.next = nodeToDelete
        nodeToDelete.next = new ListNode(4, new ListNode(5))

        deleteNode(nodeToDelete)

        expect(head.val).equal(2)
        expect(head.next.val).equal(3)
        expect(head.next.next.val).equal(4)
        expect(head.next.next.next.val).equal(5)

    })
})