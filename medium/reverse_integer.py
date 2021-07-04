class Solution:
    def reverse(self, x: int):
        negative_integer = False
        if x < 0:
            negative_integer = True
            x = x * -1
        remainder = x % 10
        division_result =(int) (x / 10)
        last_number = remainder
        while division_result>0:
            remainder=division_result%10
            division_result=(int)(division_result/10)
            last_number=(last_number)*10+remainder
        if negative_integer:
            last_number =last_number * -1
        if (last_number<-2147483648) or (last_number>2147483647):
            return 0
        return last_number
