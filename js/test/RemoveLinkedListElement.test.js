const { expect } = require("chai");
const { describe } = require("mocha");
const { ListNode } = require("../src/util/ListNode");
const { removeElements } = require("../src/RemoveLinkedListELement");

describe('should remove element from list', ()=>{
    it('should delete element from the middle', ()=>{
        const rootNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))
        resultHead = removeElements(rootNode, 2)
        expect(resultHead).not.undefined
        expect(resultHead.val).equal(1)
        expect(resultHead.next.val).equal(3)
        expect(resultHead.next.next.val).equal(4)
        expect(resultHead.next.next.next.val).equal(5)
        expect(resultHead.next.next.next.next).to.not.exist
    })
    
    it('should delete element from the beginning', ()=>{
        const rootNode = new ListNode(1, new ListNode(2, new ListNode(3)))
        resultHead = removeElements(rootNode, 1)
        expect(resultHead).not.undefined
        expect(resultHead.val).equal(2)
        expect(resultHead.next.val).equal(3)
        expect(resultHead.next.next).to.not.exist
    })
    
    it('should delete element from the end', ()=>{
        const rootNode = new ListNode(1, new ListNode(2, new ListNode(3)))
        resultHead = removeElements(rootNode, 3)
        expect(resultHead).not.undefined
        expect(resultHead.val).equal(1)
        expect(resultHead.next.val).equal(2)
        expect(resultHead.next.next).to.not.exist
    })
    
    it('should not delete', ()=>{
        const rootNode = new ListNode(1, new ListNode(2, new ListNode(3)))
        resultHead = removeElements(rootNode, 4)
        expect(resultHead).not.undefined
        expect(resultHead.val).equal(1)
        expect(resultHead.next.val).equal(2)
        expect(resultHead.next.next.val).equal(3)
        expect(resultHead.next.next.next).to.not.exist
    })
    
    it('should support empty list', ()=>{
        resultHead = removeElements({}, 4)
        expect(resultHead).not.undefined
        expect(resultHead.val).to.not.exist
        expect(resultHead.next).to.not.exist
    })

    it('should return empty list', ()=>{
        resultHead = removeElements(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1)))), 1)
        expect(resultHead).to.be.null
    })
})