package br.com.loja;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class LojaSteps {
	 
	public WebDriver driver;
	
	
	@After(order = 1)
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File ("target/screenshot/"+cenario.getId()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@After(order = 0)
	public void fecharbrowser() {	
	}
	
	

	@Dado("^que estou no site \"([^\"]*)\"$")
	public void queEstouNoSite(String arg1) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bruno Silva\\eclipse-workspace\\br.com.g1\\driver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get(arg1);
	}
	
	
	@Quando("^seleciono a vestido estampado$")
	public void selecionoAVestidoEstampado() throws Throwable {
	    driver.findElement(By.xpath("//img[@src='http://automationpractice.com/img/p/8/8-home_default.jpg']")).click();
	}
	
	@Quando("^escolho o tamanho L$")
	public void escolhoOTamanhoS() throws Throwable {
		Thread.sleep(3000);
	   driver.findElement(By.cssSelector("option[value='3']")).click();
	}
	
	@Quando("^seleciono (\\d+) unidades$")
	public void selecionoA(int quantidade) throws Throwable {
		if (quantidade == 2) {
			driver.findElement(By.xpath("//i[@class='icon-plus']")).click();
			
		}else if (quantidade == 3) {
				driver.findElement(By.xpath("//i[@class='icon-plus']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//i[@class='icon-plus']")).click();}
		}
	
	@Quando("^clico em \"([^\"]*)\"$")
	public void clicoEm(String arg1) throws Throwable {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("scrollBy(0,500)", "");
	    Thread.sleep(1000);
		driver.findElement(By.cssSelector("p[id='add_to_cart']")).click();
		 Thread.sleep(4000);
		driver.findElement(By.cssSelector("a[title='Proceed to checkout']")).click();
	}
	
	@Então("^verifico se (\\d+) de produto foi adicionado ao carrinho com sucesso$")
	public void verificoSeDeProdutoFoiAdicionadoAoCarrinhoComSucesso(int quantidade) throws Throwable {
	   if(quantidade == 2) {
		String texto = driver.findElement(By.id("summary_products_quantity")).getText();
	    assertEquals("2 Products" , texto);
	  }else if(quantidade == 3) {
		  String texto = driver.findElement(By.id("summary_products_quantity")).getText();
		  assertEquals("3 Products" , texto);
	  }
	}
	
	@Então("^verifico se o valor do frete é \"([^\"]*)\"$")
	public void verificoSeOValorDoFreteÉ(String arg1) throws Throwable {
	    String texto = driver.findElement(By.id("total_shipping")).getText();
	    assertEquals(arg1, texto);
	}
	
	
	@Quando("^seleciono a vestido$")
	public void selecionoAVestido() throws Throwable {
		driver.findElement(By.cssSelector("img[src='http://automationpractice.com/img/p/1/0/10-home_default.jpg']")).click();
	}
	
	@Quando("^clico em sign in$")
	public void clicoEmSignIn() throws Throwable {
	    driver.findElement(By.className("login")).click();
	}
	
	@Quando("^preencho meu e-mail com \"([^\"]*)\" na aba de criar conta$")
	public void preenchoMeuEMailComNaAbaDeCriarConta(String email) throws Throwable {
	   driver.findElement(By.id("email_create")).sendKeys(email);
	}
	
	@Quando("^clico em Create an account$")
	public void clicoEmCreateAnAccount() throws Throwable {
	   driver.findElement(By.id("SubmitCreate")).click();
	   Thread.sleep(2000);
	}

	@Quando("^preenche o campo nome com \"([^\"]*)\"$")
	public void preencheOCampoNomeCom(String nome) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.id("customer_firstname")).sendKeys(nome);
	}
	
	@Quando("^preenche o campo sobre nome com \"([^\"]*)\"$")
	public void preencheOCampoSobreNomeCom(String sobrenome) throws Throwable {
	  driver.findElement(By.id("customer_lastname")).sendKeys(sobrenome);
	}
	
	
	@Quando("^preenche o campo senha com \"([^\"]*)\"$")
	public void preencheOCampoSenhaCom(String senha) throws Throwable {
	    driver.findElement(By.id("passwd")).sendKeys(senha);
	}
	
	@Quando("^preenche o campo data de aniversario com \"([^\"]*)\" \"([^\"]*)\" e \"([^\"]*)\"$")
	public void preenche_o_campo_data_de_aniversario_com_e(String arg1, String arg2, String arg3) throws Throwable {
	    driver.findElement(By.id("days")).sendKeys(arg1);
	    driver.findElement(By.id("months")).sendKeys(arg2);
	    driver.findElement(By.id("years")).sendKeys(arg3);
	}
	
	
	@Quando("^preenche o campo Endereço com \"([^\"]*)\"$")
	public void preencheOCampoEndereçoCom(String endereço) throws Throwable {
	    driver.findElement(By.id("address1")).sendKeys(endereço);
	}
	
	@Quando("^preenche o campo Cidade com \"([^\"]*)\"$")
	public void preencheOCampoCidadeCom(String cidade) throws Throwable {
	    driver.findElement(By.id("city")).sendKeys(cidade);
	}
	
	@Quando("^preenche o campo Estado com \"([^\"]*)\"$")
	public void preencheOCampoEstadoCom(String estado) throws Throwable {
	    driver.findElement(By.id("id_state")).sendKeys(estado);
	}
	
	@Quando("^preenche o campo Cep com \"([^\"]*)\"$")
	public void preencheOCampoCepCom(String cep) throws Throwable {
	    driver.findElement(By.id("postcode")).sendKeys(cep);
	}
	
	@Quando("^preenche o campo Telefone com \"([^\"]*)\"$")
	public void preencheOCampoTelefoneCom(String cel) throws Throwable {
	   driver.findElement(By.id("phone_mobile")).sendKeys(cel);	}
	
	@Quando("^clico em <Register>$")
	public void clicoEmRegister() throws Throwable {
	    driver.findElement(By.id("submitAccount")).click();
	}
}