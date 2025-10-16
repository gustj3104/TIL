package mid;

public class MinimumPalindromeSubdivision {
    public static void main(String[] args) {

    }
}

/**
 * MPS[i] : S[0,,,i]에서 minimum palindrome subdivision의 크기
 * base case : MPS[0] = 1
 * recurrence relation
 *  1. i이전 j까지의 MPS + 1 // if S[j,...i] is palindrome
 *      -> S[j-1] == S[i-1]이면 palindrome
*   // O(n^3) 시간복잡도 => palindrome인지 여부를 미리 계산해놓으면 O(n^2)으로 축소
 *
 *
 */