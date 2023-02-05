package gfg;
/*
https://practice.geeksforgeeks.org/problems/eae1fbd0ac8f213a833d231e26ba4d829e79dd9c/1
 */

import gfg.util.link.Node;

public class IntersectionPointOfLinkedLists {

    public int solve(Node head1, Node head2){
        return new Intersect().intersectPoint(head1, head2);
    }

    static class Intersect
    {
        int intersectPoint(Node head1, Node head2)
        {
            Node tempPointer = head1;
            //KEY information is range of node data is -1000 to 1000.
            while (tempPointer != null){
                if (tempPointer.data < 0 ){
                    tempPointer.data = tempPointer.data - 2000;
                }else{
                    tempPointer.data = tempPointer.data + 2000;
                }
                tempPointer = tempPointer.next;
            }
            tempPointer = head2;
            while(tempPointer != null){
                if (tempPointer.data < -2000 || tempPointer.data >= 2000){
                    return tempPointer.data < 2000 ? (tempPointer.data + 2000) : (tempPointer.data - 2000);
                }
                tempPointer = tempPointer.next;
            }
            return -1;
        }
    }
}
