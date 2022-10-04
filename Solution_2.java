class Solution_2 {
    public int minSetSize(int[] arr) {
        if(isArrayValid(arr)){
            int UniqueInteger = 0;
            for(int i=0; i<arr.length; i++){
                int current_element = arr[i];
                boolean flag = true;
                for(int j=i-1; j>=0; j--){
                    if(current_element == arr[j]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    UniqueInteger++;
                }
            }
            if(UniqueInteger == 1){
                return 1;
            }
            for(int i=0; i<arr.length; i++){
                for(int j=0; j<arr.length-1; j++){
                    if(arr[j] > arr[j+1]){
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
            int frequency[] = new int[UniqueInteger];
            int frequency_index = 0;
            for(int i=0; i<arr.length; i++){
                if(i != 0 && arr[i-1] != arr[i]){
                    frequency_index++;
                }
                frequency[frequency_index]++;
            }
            for(int i=0; i<frequency.length; i++){
                for(int j=0; j<frequency.length-1; j++){
                    if(frequency[j] < frequency[j+1]){
                        int temp = frequency[j];
                        frequency[j] = frequency[j+1];
                        frequency[j+1] = temp;
                    }
                }
            }
            int maxFrequency = 0;
            for(int i=0; i<frequency.length; i++){
                maxFrequency += frequency[i];
                if(maxFrequency >= (arr.length/2)){
                    return (frequency.length-i-1);
                }
            }
        }
        return 0;
    }
    private boolean isArrayValid(int[] arr){
        if(arr.length >= 2 && arr.length <= (10^5) && arr.length%2 == 0){
            for (int i=0; i<arr.length; i++) {
                if(!(arr[i] >= 1 && arr[i] <= (10^5))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}