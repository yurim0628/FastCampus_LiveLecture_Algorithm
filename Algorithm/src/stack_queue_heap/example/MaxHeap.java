package stack_queue_heap.example;
public class MaxHeap {
    public int[] heap; // 최대 힙을 저장하는 배열
    public int size;   // 힙의 크기

    public MaxHeap(int length) {
        heap = new int[length];
        heap[0] = 1000000000; // 최대값을 나타내는 무한대 값으로 초기화
        size = 0;
    }

    // 부모 노드 방향으로 힙을 조정하는 메서드
    public void upHeap(int pos) {
        int tmp = heap[pos];
        while (heap[pos / 2] < tmp) {
            heap[pos] = heap[pos / 2];
            pos = pos / 2;
        }
        heap[pos] = tmp;
    }

    // 힙에 원소를 삽입하는 메서드
    public void insert(int num) {
        heap[++size] = num; // 힙의 끝에 원소를 추가하고 크기를 증가시킴
        upHeap(size); // 삽입한 원소를 부모 노드 방향으로 조정
    }

    // 자식 노드 방향으로 힙을 조정하는 메서드
    public void downHeap(int pos) {
        int tmp = heap[pos];
        while (pos <= size / 2) {
            int idx = pos * 2;
            if (idx < size && heap[idx] < heap[idx + 1]) idx++;
            if (tmp > heap[idx]) break;
            heap[pos] = heap[idx];
            pos = idx;
        }
        heap[pos] = tmp;
    }

    // 힙에서 최대값(루트 노드)을 추출하는 메서드
    public int get() {
        int tmp = heap[1];
        heap[1] = heap[size--]; // 루트 노드를 맨 끝 노드로 대체하고 크기를 줄임
        downHeap(1); // 루트 노드에서부터 자식 노드 방향으로 조정
        return tmp; // 추출한 최대값 반환
    }

    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap(100);

        // 원소 삽입
        mh.insert(10);
        mh.insert(5);
        mh.insert(8);
        mh.insert(15);
        mh.insert(3);
        mh.insert(12);

        // 현재 힙 출력
        for (int i = 1; i <= mh.size; i++) {
            System.out.print(mh.heap[i] + " ");
        }
        System.out.println();

        // 원소 추가 후 힙 출력
        mh.insert(20);
        for (int i = 1; i <= mh.size; i++) {
            System.out.print(mh.heap[i] + " ");
        }
        System.out.println();

        // 최대값 추출
        System.out.println(mh.get());

        // 최대값 추출 후 힙 출력
        for (int i = 1; i <= mh.size; i++) {
            System.out.print(mh.heap[i] + " ");
        }
        System.out.println();
    }
}