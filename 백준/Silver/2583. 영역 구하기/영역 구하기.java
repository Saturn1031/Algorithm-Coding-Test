import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int areaCount = 0;
        ArrayList<Integer> area = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        int M = in.nextInt();
        int N = in.nextInt();
        int K = in.nextInt();
        in.nextLine();

        int[][] monun = new int[M][N];

        // 초기화
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                monun[i][j] = 0;
            }
        }

        // 직사각형 그리기
        for (int i = 0; i < K; i++) {
            int wsX = in.nextInt();
            int wsY = in.nextInt();
            int enX = in.nextInt();
            int enY = in.nextInt();
            in.nextLine();

            for (int j = wsY; j < enY; j++) {
                for (int k = wsX; k < enX; k++) {
                    monun[j][k] = 1;
                }
            }
        }

        // 영역 세기
        Queue<String> visitedPoints = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (monun[i][j] == 0) {
                    monun[i][j] = 1;
                    area.add(visit(i, j, monun, visitedPoints) + 1);
                    areaCount++;
                }
            }
        }

        System.out.println(areaCount);
        area.sort(Comparator.naturalOrder());
        for (int i = 0; i < area.size(); i++) {
            System.out.print(area.get(i) + " ");
        }
    }

    static int visit(int i, int j, int[][] monun, Queue<String> visitedPoints) {
        int count = 0;

        // 하
        int checkI = i - 1;
        int checkJ = j;

        if (checkI >= 0 && checkI < monun.length && checkJ >= 0 && checkJ < monun[0].length) {
            if (monun[checkI][checkJ] == 0) {
                visitedPoints.add(checkI + "," + checkJ);
                monun[checkI][checkJ] = 1;
                count++;
            }
        }

        // 우
        checkI = i;
        checkJ = j + 1;

        if (checkI >= 0 && checkI < monun.length && checkJ >= 0 && checkJ < monun[0].length) {
            if (monun[checkI][checkJ] == 0) {
                visitedPoints.add(checkI + "," + checkJ);
                monun[checkI][checkJ] = 1;
                count++;
            }
        }

        // 상
        checkI = i + 1;
        checkJ = j;

        if (checkI >= 0 && checkI < monun.length && checkJ >= 0 && checkJ < monun[0].length) {
            if (monun[checkI][checkJ] == 0) {
                visitedPoints.add(checkI + "," + checkJ);
                monun[checkI][checkJ] = 1;
                count++;
            }
        }

        // 좌
        checkI = i;
        checkJ = j - 1;

        if (checkI >= 0 && checkI < monun.length && checkJ >= 0 && checkJ < monun[0].length) {
            if (monun[checkI][checkJ] == 0) {
                visitedPoints.add(checkI + "," + checkJ);
                monun[checkI][checkJ] = 1;
                count++;
            }
        }

        for (int k = 0; k < visitedPoints.size(); k++) {
            String nextStr = visitedPoints.poll();
            int nextI = Integer.parseInt(nextStr.split(",")[0]);
            int nextJ = Integer.parseInt(nextStr.split(",")[1]);

            count += visit(nextI, nextJ, monun, visitedPoints);
        }

        return count;
    }
}
