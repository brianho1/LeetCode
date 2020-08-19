'''
https://leetcode.com/problems/integer-to-english-words/
273 Integer to English Words
'''


class Solution:
    def numberToWords(self, num: int) -> str:
        digits = {0:'Zero', 1: 'One', 2: 'Two', 3: 'Three', 4:'Four', 5:'Five', 6:'Six', 7:'Seven', 8:'Eight', 9:'Nine', 10:'Ten', 11: 'Eleven', 12:'Twelve', 13:'Thirteen', 14:'Fourteen', 15:'Fifteen', 16:'Sixteen', 17:'Seventeen', 18:'Eighteen', 19:'Nineteen', 20:'Twenty', 30: 'Thirty', 40: 'Forty', 50:'Fifty', 60:'Sixty', 70:'Seventy', 80:'Eighty', 90:'Ninety'}
        ranks = ['Hundred','Thousand','Million','Billion']
        res = ""
        if num == 0:
            return digits[0]
        
        def group3(num:int) -> str:
            s = ""
            rank = 0
            while num != 0:
                if num % 100 == 0:
                    return digits[num / 100] + " " + ranks[0]
                
                if rank == 0 and num % 100 > 10 and num % 100 < 20:
                    s = digits[num % 100] + s
                    num //= 100
                    rank += 2
                    continue
                    
                if rank == 0 and (num % 100) % 10 == 0:
                    s = digits[num % 100] + s
                    rank += 2
                    num //= 100
                
                if rank == 0:
                    s = digits[num % 10] + s
                    # print(s)
                elif rank == 1:
                    if num % 10 != 0:
                        s = digits[(num % 10) * 10] + " " + s
                else:
                    if num != 0: s = digits[num % 10] + " " + ranks[0] + " " + s
                num //= 10
                rank += 1
                # print(s)
            return s
        
        
        rank3 = 0
        while num != 0:
            combo = num % 1000
            if combo != 0:
                if rank3 == 0: 
                    res = group3(combo) + res
                else:
                    if len(res) > 0:
                        res = group3(combo) + " " + ranks[rank3] + " " + res
                    else:
                        res = group3(combo) + " " + ranks[rank3]
            num //= 1000
            rank3 += 1

        return res
    
            
        