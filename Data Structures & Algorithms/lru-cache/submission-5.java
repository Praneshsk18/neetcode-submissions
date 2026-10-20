class LRUCache {
    HashMap<Integer,Dll> map = new HashMap<>();
    int capacity;
    Dll head = new Dll();
    Dll tail = new Dll();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Dll node = map.getOrDefault(key, new Dll(-1));
        if(node.value==-1){
            return -1;
        }
        Dll ptr = head.next;
        while(!ptr.equals(node)){
            ptr = ptr.next;
        }
        ptr.next.prev = ptr.prev;
        ptr.prev.next = ptr.next;
        Dll temp = head.next;
        head.next = node;
        node.next = temp;
        temp.prev = node;
        node.prev = head;
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Dll node = map.get(key);
            map.put(key, node);
            node.value = value;

            // Remove node
            node.prev.next = node.next;
            node.next.prev = node.prev;

            // Move to front
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;

            return;
        }
        if(map.size()>=capacity){
            Dll temp = tail.prev;
            map.remove(temp.key);
            tail.prev = temp.prev;
            temp.prev.next = tail;
        }
        Dll node = new Dll(key, value);
        map.put(key, node);
        Dll temp = head.next;
        head.next = node;
        node.next = temp;
        temp.prev = node;
        node.prev = head;
    }
}

class Dll{
    int key;
    int value;
    Dll prev;
    Dll next;
    Dll(){}
    Dll(int value){
        this.value = value;
    }
    Dll(int key,int value){
        this.key = key;
        this.value = value;
    }
}