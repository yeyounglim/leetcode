import java.util.LinkedList;
class BrowserHistory {
    private int current;
    LinkedList<String> linkedList;
    public BrowserHistory(String homepage) {
        linkedList = new LinkedList<>();
        linkedList.add(homepage);
        current = 0;
    }
    public void visit(String url) {
        current++;

        if(current == linkedList.size()){
            linkedList.add(url);
        }
        else{
            linkedList.set(current,url);
        }
        while(current < linkedList.size()-1){
            linkedList.removeLast();
        }
    }
    public String back(int steps) {
        current = (current - steps > 0) ? current - steps : 0;
        return linkedList.get(current);
    }
    public String forward(int steps) {
        current = (current + steps > linkedList.size() - 1) ? linkedList.size() - 1 : current + steps;
        return linkedList.get(current);
    }
}