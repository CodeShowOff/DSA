public class BrowserTabsTracking {
    TabNode currentTab;

    public BrowserTabsTracking(String homepage){
        currentTab = new TabNode(homepage);
    }

    public String visit(String url){
        TabNode newTab = new TabNode(url);
        currentTab.next = newTab;
        newTab.prev = currentTab;
        currentTab = currentTab.next;
        return currentTab.url;
    }

    public String moveForward(){
        if(currentTab.next == null){
            return currentTab.url;
        }else{
            currentTab = currentTab.next;
            return currentTab.url;
        }
    }

    public String moveBackward(){
        if(currentTab.prev == null){
            return currentTab.url;
        }else{
            currentTab = currentTab.prev;
            return currentTab.url;
        }
    }

    public static void main(String[] args) {
        BrowserTabsTracking obj = new BrowserTabsTracking("www.google.com");

        System.out.print(
            obj.visit("facebook.com") + "\n" +
            obj.visit("instagram.com") + "\n" +
            obj.visit("twitter.com") + "\n" +
            obj.moveBackward() + "\n" +
            obj.moveBackward() + "\n" +
            obj.moveForward() + "\n" +
            obj.visit("youtube.com") + "\n" +
            obj.moveBackward() + "\n" +
            obj.moveForward()
        );

    }
}

class TabNode{
    String url;
    TabNode next;
    TabNode prev;

    TabNode(String url){
        this.url = url;
        this.next = null;
        this.prev = null;
    }
}
