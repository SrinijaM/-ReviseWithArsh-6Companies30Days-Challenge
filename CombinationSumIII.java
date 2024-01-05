//Combination Sum III
//Find all valid combinations of k numbers that sum up to n
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // if k=1 obviously o/p=n but 2<=k<=9 -- thus no need to consider
        // if k=2 and no dupicates so check compliments(i and n-i) till n/2
        //for k>=2 n never is part of the digits pair
        // another case: if n=1 and k>1 return [] 
        // so k should never be greater than n
        // too much time complexity if we use each digit and check
        // we can use recursion because for each digit compliments should be found
        List<List<Integer>> result =new ArrayList<>();
        compliments(result,n,k,1,new ArrayList<>()); //sending result, n ,k , starting variable and current list
        return result;
    }
    public void compliments(List<List<Integer>> result,int n,int k,int i, List<Integer> current){
        if(n==0&&k==0){
            result.add(new ArrayList<>(current)); 
        } 
        if((k!=0&&n==0)||k==0||i==10||i>n)
        return;
        current.add(i);
        compliments(result,n-i,k-1,i+1,current);
        System.out.println(current+""+n+""+k);
        current.remove(current.size()-1); //removing last element and incrementing it by 1
        compliments(result,n,k,i+1,current);
    }
}
//time complexity O(1)
//space complexity O(k) 
