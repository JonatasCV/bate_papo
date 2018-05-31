package com.batepapo.controller;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.batepapo.config.StageManager;
import com.batepapo.service.UserService;
import com.batepapo.ws.Usuario;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;


@Controller
public class UserController implements Initializable{
	
	@FXML
    private Label userId;
	
	@FXML
    private TextField nome;

    @FXML
    private TextField ipAddress;
    
    @FXML
    private Button reset;
	
	@FXML
    private Button saveUser;
	
	@FXML
	private TableView<Usuario> userTable;

	@FXML
	private TableColumn<Usuario, Long> colUserId;

	@FXML
	private TableColumn<Usuario, String> colNome;

	@FXML
	private TableColumn<Usuario, String> colIP;

	@FXML
    private TableColumn<Usuario, Boolean> colEdit;
	
	@FXML
    private MenuItem deleteUsers;
	
	@Lazy
    @Autowired
    private StageManager stageManager;
	
	@Autowired
	private UserService userService;
	
	private ObservableList<Usuario> userList = FXCollections.observableArrayList();
	
	@FXML
	private void exit(ActionEvent event) {
		Platform.exit();
    }
    
    @FXML
    void reset(ActionEvent event) {
    	clearFields();
    }
    
    @FXML
    private void saveUser(ActionEvent event){
    		
		if(userId.getText() == null || userId.getText() == ""){
			if( emptyValidation("Nome", getNome().isEmpty()) && emptyValidation("Ip", getIpAddress().isEmpty())){
		
				Usuario user = new Usuario();
				user.setNome(getNome());
				user.setIPaddress(getIpAddress());
    			Usuario newUser = userService.save(user);
    			
    			saveAlert(newUser);
			}
			
		}else{
			Usuario user = new Usuario();
			user.setCodUsuario(getUserId());
			user.setNome(getNome());
			user.setIPaddress(getIpAddress());
			
			Usuario updatedUser =  userService.update(user);
			updateAlert(updatedUser);
		}
		
		clearFields();
		loadUserDetails();
    	
    	
    }
    
    @FXML
    private void deleteUsers(ActionEvent event){
    	List<Usuario> users = userTable.getSelectionModel().getSelectedItems();
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmação");
		alert.setHeaderText(null);
		alert.setContentText("Você tem certeza que deseja deletar os registros selecionados?");
		Optional<ButtonType> action = alert.showAndWait();
		
		if(action.get() == ButtonType.OK) { 
			for (Usuario user : users) {
				userService.delete(user.getCodUsuario());
			}
		}
		deleteAlert(); 	
    	loadUserDetails();
    }
    
   	private void clearFields() {
		userId.setText(null);
		nome.clear();
		ipAddress.clear();
	}
	
	private void saveAlert(Usuario user){
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Usuario salvo com sucesso.");
		alert.setHeaderText(null);
		alert.setContentText("Usuario "+user.getNome()+" "+user.getIPaddress()+" id é "+ user.getCodUsuario() +".");
		alert.showAndWait();
	}
	
	private void updateAlert(Usuario user){
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Usuario atualizado com sucesso.");
		alert.setHeaderText(null);
		alert.setContentText("Usuario "+user.getNome()+" "+user.getIPaddress() +" foi atualizado.");
		alert.showAndWait();
	}
	
	private void deleteAlert(){
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Usuario(s) deletado(s) com sucesso.");
		alert.setHeaderText(null);
		alert.setContentText("Usuario(s) foi/foram deletados com sucesso.");
		alert.showAndWait();
	}
	
	public Long getUserId() {
		return Long.parseLong(userId.getText());
	}
	
	public String getNome() {
		return nome.getText();
	}

	public String getIpAddress() {
		return ipAddress.getText();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		userTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		setColumnProperties();
		
		// Add all users into table
		loadUserDetails();
	}
	
	
	
	/*
	 *  Set All userTable column properties
	 */
	private void setColumnProperties(){		
		colUserId.setCellValueFactory(new PropertyValueFactory<>("codUsuario"));
		colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colIP.setCellValueFactory(new PropertyValueFactory<>("iPaddress"));
		colEdit.setCellFactory(cellFactory);
	}
	
	Callback<TableColumn<Usuario, Boolean>, TableCell<Usuario, Boolean>> cellFactory = 
			new Callback<TableColumn<Usuario, Boolean>, TableCell<Usuario, Boolean>>()
	{
		@Override
		public TableCell<Usuario, Boolean> call( final TableColumn<Usuario, Boolean> param)
		{
			final TableCell<Usuario, Boolean> cell = new TableCell<Usuario, Boolean>()
			{
				Image imgEdit = new Image(getClass().getResourceAsStream("/images/edit.png"));
				final Button btnEdit = new Button();
				
				@Override
				public void updateItem(Boolean check, boolean empty)
				{
					super.updateItem(check, empty);
					if(empty)
					{
						setGraphic(null);
						setText(null);
					}
					else{
						btnEdit.setOnAction(e ->{
							Usuario user = getTableView().getItems().get(getIndex());
							updateUser(user);
						});
						
						btnEdit.setStyle("-fx-background-color: transparent;");
						ImageView iv = new ImageView();
				        iv.setImage(imgEdit);
				        iv.setPreserveRatio(true);
				        iv.setSmooth(true);
				        iv.setCache(true);
						btnEdit.setGraphic(iv);
						
						setGraphic(btnEdit);
						setAlignment(Pos.CENTER);
						setText(null);
					}
				}

				private void updateUser(Usuario user) {
					userId.setText(Long.toString(user.getCodUsuario()));
					nome.setText(user.getNome());
					ipAddress.setText(user.getIPaddress());
				}
			};
			return cell;
		}
	};

	
	
	/*
	 *  Add All users to observable list and update table
	 */
	private void loadUserDetails(){
		userList.clear();
		userList.addAll(userService.findAll());

		userTable.setItems(userList);
	}
	
	private boolean emptyValidation(String field, boolean empty){
        if(!empty){
            return true;
        }else{
        	validationAlert(field, true);            
            return false;            
        }
    }	
	
	private void validationAlert(String field, boolean empty){
		Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Erro de Validação");
        alert.setHeaderText(null);
    	if(empty) {
    		alert.setContentText("O campo "+ field + " não pode ser vazio");
    	}else {
    		alert.setContentText("Por favor preencha corretamente o campo "+ field);	
    	}
        alert.showAndWait();
	}
}
