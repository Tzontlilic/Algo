#-*- coding:utf-8 -*-
def MergeSort(lists):
	if len(lists) <= 1: # 如果为单个数字就返回
			return lists   
	else:
		num  = int(len(lists) / 2)
		L = MergeSort(lists[:num])	
		R = MergeSort(lists[num:])
		return Merge(L, R)

def Merge(L, R):
	l, r = 0, 0 
	result = []
	while(l < len(L) and r < len(R)):
		if(L[l] <= R[r]):
			result.append(L[l])
			l += 1
		else:
			result.append(R[r])
			r += 1
	result += L[l:]		# 如果左右两边长度不同，就把没比完的加到后面
	result += R[r:]

	return result

print(MergeSort([1,1,12,3,4]))
print("change")
