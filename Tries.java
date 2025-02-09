public class Tries{
    public static void main(String[] args) {
        /**
         *  What is a trie?
         * 
         *      1. Trie basically comes from the word retrieval.
         *      2. The main purpose of this data structure is to retrieve stored information very fast.
         *      3. Applications - Auto complete words, search contacts in phone, spell checkers in docs.
         * 
         * What is a TrieNode? - https://youtu.be/2ZLl8GAk1X4?t=139466
         *      1. A TrieNode is a Trie represents a single alphabet of the word.
         * 
         * Representation of a TrieNode in Trie - https://youtu.be/2ZLl8GAk1X4?t=139548
         * A TrieNode class in Trie consists of two data members.
         *      1. TrieNode[] children - An array which refers to other TrieNodes in Trie, also called as
         *         child nodes of a TrieNode. The size of array is usually taken as 26 (if we are storing english words)
         *      2. boolean isWord - A boolean value to indicate the end of word. This value is set as true
         *         when a word is inserted completely.
         * 
         * Implementation of the trie class - https://youtu.be/2ZLl8GAk1X4?t=139995
         *      1. A trie will be implemented using TrieNode class
         *      2. A root TrieNode is at top with empty value having 26 links (one per alphabet)
         *      3. The links are either null or points to another TrieNode.
         */

         
    }
}
