def QuickSort(lists):
	key = lists[0]

	while(i != j):

		for j in range(len(lists) - 1, i):
			if lists[j] < key:
				swap(lists[i], lists[j])
				break
			else:
				continue

print('change')