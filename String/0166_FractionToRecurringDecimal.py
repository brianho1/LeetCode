class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        
        if denominator == 0:
            return
        res = ""
        in_decimal = False
        collector = set()
        count = 0
        hmap = {}
        neg = False
        
        if numerator == 0: return '0'
        if (numerator // abs(numerator)) * (denominator // abs(denominator)) < 0: neg = True
        numerator = abs(numerator)
        denominator = abs(denominator)
        while (True):
            x = numerator // denominator
            r = numerator % denominator
            if in_decimal and numerator not in hmap: hmap[numerator ] = count
            elif in_decimal: 
                res = res[:hmap[numerator]] + '(' + res[hmap[numerator]:]
                res = res + ')'
                break
            if r == 0:
                res = res + str(x)
                break
            elif x == 0:
                if not in_decimal: 
                    if len(res) > 0: 
                        res = res + "."
                        count += 1
                    else: 
                        res = res + "0."
                        count += 2
                    in_decimal = True
                else: 
                    res = res + '0'
                    count += 1
                numerator *= 10 # 4 / 6 = 0 r = 6
            else:
                res = res + str(x)
                count += len(str(x))
                numerator = r if not in_decimal else 10 * r
            # print(hmap)
        return res if not neg else "-" + res
    
    '''
    1 / 60 = 0 r = 60 res = 0.
    10 / 60 = 0 r = 60 res = 0.0
    100 / 60 = 1 r = 40 res = 0.01
    400 / 60 = 6 r = 40 res = 0.016
    '''