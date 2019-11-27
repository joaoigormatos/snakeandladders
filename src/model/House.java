package model;

public  class House {
    private IEffect iEffect;
    public House(){

    }

    public boolean hasEffect(){
        return iEffect!=null;
    }

    public IEffect getiEffect() {
        return iEffect;
    }

    public void setiEffect(IEffect iEffect) {
        this.iEffect = iEffect;
    }
}
