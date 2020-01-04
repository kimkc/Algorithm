testCaseNum = int(input())
for i in range(testCaseNum):
    N,Q = map(int,input().split())
    box = [0 for j in range(N)]
    for x in range(Q):
        L,R=map(int,input().split())
        L=L-1

        for y in range(L,R):
            box[y]=x+1

    print("#"+str((i+1))+" ",end="")
    for z in range(len(box)):
        print(box[z], end=" ")
    print()
    
