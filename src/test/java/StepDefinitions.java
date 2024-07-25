import com.github.yuizho.Drink;
import com.github.yuizho.VendingMachine;
import com.github.yuizho.Yen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {
    VendingMachine 自動販売機;
    Drink 出てきたドリンク;
    Yen おつり;

    @Given("自動販売機がある")
    public void 自動販売機がある() {
        自動販売機 = new VendingMachine();
    }

    @When("{int}円を入れる")
    public void お金をいれる(int paidAmount) {
        自動販売機.insertYen(new Yen(paidAmount));
    }

    @When("'{word}'を選ぶ")
    public void ドリンクを選ぶ(String drink) {
        自動販売機.chooseDrink(Drink.valueOf(drink));
        出てきたドリンク = 自動販売機.getDrink().orElse(null);
        おつり = 自動販売機.getChange().orElse(null);
    }

    @Then("'{word}'が出てくる")
    public void ドリンクが出てくる(String drink) {
        assertThat(出てきたドリンク).isEqualTo(Drink.valueOf(drink));
    }

    @Then("{int}円が返ってくる")
    public void おつりが出てくる(int change) {
        assertThat(おつり).isEqualTo(new Yen(change));
    }
}
