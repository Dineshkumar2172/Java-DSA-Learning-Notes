public class Hashing {
    public static void main(String[] args) {
        // What is Hashing? - https://youtu.be/2ZLl8GAk1X4?t=125041
        //      1. Hashing is a technique used for storing, retrieving and removing information as quickly as possible.
        //      2. It's a process of converting a arbitrary size key into fixed sized value. The conversion is
        //         done via a special function called Hash function.
        //      3. The operation supported by hashing such as storing, retrieving and removing information have average
        //         runtime complexity of O(1).

        // What are Hash Functions? - https://youtu.be/2ZLl8GAk1X4?t=125912
        //      1. A hash function simply takes an arbitrary size key and provides fixed size value also called as index.
        //      2. Commonly used hash function - modular hash function  - https://youtu.be/2ZLl8GAk1X4?t=126086
        //              i. A modular hash function simply takes a key and size of array, returns remainder by dividing key by size.
        //             ii. The remainder is used as an index to store the key in an array of provided size.

        // What is a hash table? - https://youtu.be/2ZLl8GAk1X4?t=126552
        //      1. It is a generalised form of an array. (which uses hash functions to store elements)
        //      2. It stores the data in form of key-value pair. (key is based on the index from hash function)
        //      3. It converts key to an index using hash function.
        //      4. Taking the converted index we store key-value in array.
        //      5. The primary operations supported by HashTable are - 
        //              put(key, value) - Adds key-value pair against unique key.
        //              get(key) - Get value for the provided key.
        //              remove(key) - Removes the key-value pair from HashTable.
        //      6. Average running time is O(1)
        //      7. Java collections framework has hashmap class (pretty much same as hash table class) - if we want to deal with key-value pair
        //         and HashSet class if we want to deal with only keys.
        //
        // Collision - https://youtu.be/2ZLl8GAk1X4?t=126955
    }
}
