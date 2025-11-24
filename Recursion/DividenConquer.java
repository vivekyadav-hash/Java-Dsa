public class DividenConquer {

    //print Arr after the mergeSorting 
    public static void printArr(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //merge Sort happen here
    public static void mergeSort(int[] arr, int si, int ei){
        if(si >= ei) return;

        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);//left side arr 
        mergeSort(arr, mid + 1, ei);// right side arr
        merge(arr, si, mid, ei);
    }


    //merge the two seperate arr with arranging them 
    public static void merge(int arr[], int si, int mid, int ei){
        int temp[] = new int[ei - si + 1];
        int i = si, j = mid + 1, k = 0;

        while(i <= mid && j <= ei){// compare the element to arrange in ascending order
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid){// temp arr for left side 
            temp[k++] = arr[i++];
        }

        while(j <= ei){//temp arr for right side
            temp[k++] = arr[j++];
        }

        //putting the element to the original arr from temp one 
        for(k = 0, i = si; k < temp.length; k++, i++){
            arr[i] = temp[k];
        }
    }

    //Pivot & Partition 
    public static void quickSort(int []arr , int si, int ei){
if(si >= ei){
    return;
}

int pIdx = partition(arr, si, ei);
quickSort(arr, si, pIdx-1);//Left
quickSort(arr, pIdx+1, ei);//Right

}

public static int partition(int [] arr ,int si, int ei){

    int pivot = arr[ei];
    int i = si-1;//to make places in the arr for pivot
 
    for(int j=si; j<arr.length; j++){
      if(arr[j] < pivot){
        i++;
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      }
    }
    i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i ;
}
 
public static int search(int [] arr,  int target,int si , int ei){
if(si > ei){
    return -1;
}

int mid = si+(ei-si)/2;

//case FOUND
if(arr[mid] == target){
    return mid;
}

//mid on L1
if(arr[si] <= arr[mid]){
//case a: left
if(arr[si] <= target && target <= arr[mid]){
   return search(arr, target, si, mid-1);

}else{
    return search(arr, target ,mid+1 , ei);
}
}
    //mid on L2
    else{
     // case c: right
     if(arr[mid] <= target && target <= arr[ei]){
        return search(arr, target, mid+1, ei);
     }else{
        return search(arr, target ,si, mid-1 );
     }
    }

}
   
    
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
       int target = 0;
       int tarIdx =search(arr, target, 0, arr.length-1);
       System.out.print(tarIdx);
    }
}


