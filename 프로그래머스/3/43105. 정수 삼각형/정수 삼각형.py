def solution(triangle):
    dp = [[0 for i in range(j+2)] for j in range(len(triangle))]
    dp[0][0] = triangle[0][0]
    
    for r in range(1, len(triangle)):
        for c in range(0, r+1):
            dp[r][c] = max(dp[r][c], dp[r-1][c-1]+triangle[r][c], dp[r-1][c]+triangle[r][c])
            
    return max(dp[len(triangle)-1])