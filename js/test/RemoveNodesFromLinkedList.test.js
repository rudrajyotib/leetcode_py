const { describe } = require("mocha");
const { ListNode } = require("../src/util/ListNode");
const { removeNodes } = require("../src/RemoveNodesFromLinkedList");
const { expect } = require("chai");

describe('should make monotonically decreasing linked list', ()=>{
    it('should make list without repeat', ()=>{
        const resultHead = removeNodes(new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8))))))
        expect(resultHead).to.not.null
        expect(resultHead.val).equal(13)
        expect(resultHead.next.val).equal(8)
        expect(resultHead.next.next).to.be.null
    })
    
    it('should make list without repeat set 2', ()=>{
        const resultHead = removeNodes(new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8, new ListNode(1)))))))
        expect(resultHead).to.not.null
        expect(resultHead.val).equal(13)
        expect(resultHead.next.val).equal(8)
        expect(resultHead.next.next.val).equal(1)
        expect(resultHead.next.next.next).to.be.null
    })
    
    it('should make list with repeat', ()=>{
        const resultHead = removeNodes(new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8, new ListNode(8)))))))
        expect(resultHead).to.not.null
        expect(resultHead.val).equal(13)
        expect(resultHead.next.val).equal(8)
        expect(resultHead.next.next.val).equal(8)
        expect(resultHead.next.next.next).to.be.null
    })
    
    it('should not delete any with repeat', ()=>{
        const resultHead = removeNodes(new ListNode(5, new ListNode(4 , new ListNode(3, new ListNode(3)))))
        expect(resultHead).to.not.null
        expect(resultHead.val).equal(5)
        expect(resultHead.next.val).equal(4)
        expect(resultHead.next.next.val).equal(3)
        expect(resultHead.next.next.next.val).equal(3)
        expect(resultHead.next.next.next.next).to.be.null
    })
    
    it('should not delete any without repeat', ()=>{
        const resultHead = removeNodes(new ListNode(5, new ListNode(4 , new ListNode(3, new ListNode(2)))))
        expect(resultHead).to.not.null
        expect(resultHead.val).equal(5)
        expect(resultHead.next.val).equal(4)
        expect(resultHead.next.next.val).equal(3)
        expect(resultHead.next.next.next.val).equal(2)
        expect(resultHead.next.next.next.next).to.be.null
    })
    
    it('should support single element', ()=>{
        const resultHead = removeNodes(new ListNode(5))
        expect(resultHead).to.not.null
        expect(resultHead.val).equal(5)
        expect(resultHead.next).to.be.null
    })
    
    it('should support repeat of single element', ()=>{
        const resultHead = removeNodes(new ListNode(5, new ListNode(5, new ListNode(5))))
        expect(resultHead).to.not.null
        expect(resultHead.val).equal(5)
        expect(resultHead.next.val).equal(5)
        expect(resultHead.next.next.val).equal(5)
        expect(resultHead.next.next.next).to.be.null
    })


})