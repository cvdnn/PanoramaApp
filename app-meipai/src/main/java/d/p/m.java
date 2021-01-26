package d.p;

import androidx.lifecycle.LiveData;

/* compiled from: MutableLiveData */
public class m<T> extends LiveData<T> {
    public void a(T t) {
        LiveData.a("setValue");
        this.f961f++;
        this.f959d = t;
        b(null);
    }
}
