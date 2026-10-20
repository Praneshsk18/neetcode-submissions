class LRUCache {
    Map<Integer,Q> map = new HashMap<>();
    Q head = new Q();
    Q tail = new Q();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Q node = map.get(key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
        Q temp = head.next;
        head.next = node;
        node.next = temp;
        temp.prev = node;
        node.prev = head;
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Q node = map.get(key);
            node.value = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            Q temp = head.next;
            head.next = node;
            node.next = temp;
            temp.prev = node;
            node.prev = head;
            return;
        }
        if(map.size()>=capacity){
            Q temp = tail.prev;
            temp.prev.next = tail;
            tail.prev = temp.prev;
            map.remove(temp.key);
        }
        Q node = new Q();
        map.put(key, node);
        node.key = key;
        node.value = value;
        Q temp = head.next;
        head.next = node;
        node.next = temp;
        temp.prev = node;
        node.prev = head;
    }
}

class Q{
    int key;
    int value;
    Q prev;
    Q next;
    Q(){}
}