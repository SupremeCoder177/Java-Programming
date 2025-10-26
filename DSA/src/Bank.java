public class Bank {
    
    long[] balance;
    int num_accounts;
    
    public Bank(long[] balance){
        this.balance = balance;
        this.num_accounts = balance.length;
    }
    
    public boolean transfer(int account1, int acoount2, long money){
        if(!(account1 >= 1 && account1 <= this.num_accounts)) return false;
        if(!(acoount2 >= 1 && acoount2 <= this.num_accounts)) return false;
        if(this.balance[account1 - 1] < money) return false;
        this.balance[account1 - 1] -= money;
        this.balance[acoount2 - 1] += money;
        return true;
    }
    
    public boolean deposit(int account, long money){
        if(!(account >= 1 && account <= this.num_accounts)) return false;
        this.balance[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money){
        if(!(account >= 1 && account <= this.num_accounts)) return false;
        if(this.balance[account - 1] < money) return false;
        this.balance[account - 1] -= money;
        return true;
    }
}
