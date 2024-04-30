package com.imrob.locadoraveiculos.gui.components;

import com.formdev.flatlaf.FlatClientProperties;
import com.imrob.locadoraveiculos.gui.cadastro.CadastroCarroGUI;
import com.imrob.locadoraveiculos.gui.cadastro.CadastroClienteGUI;
import com.imrob.locadoraveiculos.gui.cadastro.CadastroModeloGUI;
import com.imrob.locadoraveiculos.gui.cadastro.CadastroSeguradoraGUI;
import com.imrob.locadoraveiculos.gui.forms.CatalogoVeiculos;
import com.imrob.locadoraveiculos.gui.forms.LocacaoForm;
import com.imrob.locadoraveiculos.gui.gerenciar.ListaCarrosGUI;
import com.imrob.locadoraveiculos.gui.gerenciar.ListaClientesGUI;
import com.imrob.locadoraveiculos.gui.gerenciar.ListaSeguradoraGUI;
import java.awt.*;
import java.awt.geom.Point2D;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import raven.drawer.component.header.SimpleHeader;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.*;
import raven.drawer.component.menu.data.Item;
import raven.swing.AvatarIcon;
import raven.swing.blur.BlurChild;
import raven.swing.blur.style.GradientColor;
import raven.swing.blur.style.Style;
import raven.swing.blur.style.StyleBorder;
import raven.swing.blur.style.StyleOverlay;

public class SystemMenu extends BlurChild {

    public SystemMenu() {
        super(new Style()
                .setBlur(30)
                .setBorder(new StyleBorder(10)
                        .setOpacity(0.15f)
                        .setBorderWidth(1.2f)
                        .setBorderColor(new GradientColor(new Color(200, 200, 200), new Color(150, 150, 150), new Point2D.Float(0, 0), new Point2D.Float(1f, 0)))
                )
                .setOverlay(new StyleOverlay(new Color(0, 0, 0), 0.2f))
        );
        init();
    }

    private void init() {
        setLayout(new MigLayout("wrap,fill", "[fill]", "[grow 0][fill]"));
        simpleMenu = new SimpleMenu(getMenuOption());

        simpleMenu.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(simpleMenu);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.getVerticalScrollBar().setOpaque(false);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, "" +
                "trackArc:999;" +
                "width:5;" +
                "thumbInsets:0,0,0,0");

        // header
        SimpleHeader header = new SimpleHeader(getHeaderData());
        header.setOpaque(false);
        add(header);
        add(scrollPane);
    }

    private SimpleHeaderData getHeaderData() {
        return new SimpleHeaderData()
                .setTitle("Rob Silva")
                .setDescription("Java Developer")
                .setIcon(new AvatarIcon(getClass().getResource("/locadora/images/profile.png"), 60, 60, 999));
    }

    private SimpleMenuOption getMenuOption() {
        raven.drawer.component.menu.data.MenuItem items[] = new raven.drawer.component.menu.data.MenuItem[]{
                new Item.Label("PRINCIPAL"),
                new Item("Painel", "dashboard.svg"),
                new Item.Label("GERAL"),
                new Item("Locação", "ui.svg")
                        .subMenu("Nova Locação")
                        .subMenu("Visualizar Locações")
                        .subMenu("Relatório de Locações"),
                new Item("Veículos", "car.svg")
                        .subMenu("Catálogo")
                        .subMenu("Adicionar Novo")
                        .subMenu("Gerenciar Veículos"),
                new Item("Clientes", "cliente.svg")
                        .subMenu("Adicionar Cliente")
                        .subMenu("Gerenciar Clientes"),
                new Item("Seguradoras", "seguradora.svg")
                        .subMenu("Adicionar Seguradora")
                        .subMenu("Gerenciar Seguradora"),
                new Item.Label("OUTROS"),
                new Item("Configurações", "config.svg")
                        .subMenu("Dados da Empresa")
                        .subMenu("Configuração de Usuario")
                        .subMenu("Configuração de Notificações"),
                new Item("Ajuda", "help.svg")
                        .subMenu("Documentação")
                        .subMenu("Suporte")
                        .subMenu("Sobre")
        };
        return new SimpleMenuOption()
                .setBaseIconPath("locadora/menu")
                .setIconScale(0.5f)
                .setMenus(items)
                .setMenuStyle(new SimpleMenuStyle() {
                    @Override
                    public void styleMenuPanel(JPanel panel, int[] index) {
                        panel.setOpaque(false);
                    }

                    @Override
                    public void styleMenuItem(JButton menu, int[] index) {
                        menu.setContentAreaFilled(false);
                    }
                })
                .addMenuEvent(new MenuEvent() {
                    @Override
                    public void selected(MenuAction menuAction, int[] ints) {
                        System.out.print("Menu select");
                        if (ints.length == 1) {
                            int index = ints[0];
                            if (index == 0) {
                                FormManager.getInstance().showForm("Dashboard", new CadastroModeloGUI());
                            }
                        }else if(ints.length == 2){
                            int index=ints[0];
                            int subIndex=ints[1];
                            if(index==1){
                                if(subIndex==0){
                                    FormManager.getInstance().showForm("Nova Locação", LocacaoForm.getInstance());
                                }else if(subIndex==1){
                                    FormManager.getInstance().showForm("Visualizar Locações", new CadastroCarroGUI());
                                }else if(subIndex==2){
                                    FormManager.getInstance().showForm("Relatório de Locações", new CadastroCarroGUI());
                                }
                            } else if(index==2){
                                if(subIndex==0){
                                    FormManager.getInstance().showForm("Catálogo", new CatalogoVeiculos());
                                }else if(subIndex==1){
                                    FormManager.getInstance().showForm("Cadastro de Veículo", new CadastroCarroGUI());
                                }else if(subIndex==2){
                                    FormManager.getInstance().showForm("Gerenciar Veículos", new ListaCarrosGUI());
                                }
                            } else if(index==3){
                                if(subIndex==0){
                                    FormManager.getInstance().showForm("Cadastro de Cliente", new CadastroClienteGUI(), false);
                                }else if(subIndex==1){
                                    FormManager.getInstance().showForm("Gerenciar Clientes", new ListaClientesGUI());
                                }
                            } else if(index==4){
                                if(subIndex==0){
                                    FormManager.getInstance().showForm("Cadastro de Seguradora", new CadastroSeguradoraGUI());
                                } else if(subIndex==1){
                                    FormManager.getInstance().showForm("Gerenciar Seguradoras", new ListaSeguradoraGUI());
                                }
                            } else if(index==5){
                                if(subIndex==0){
                                    FormManager.getInstance().showForm("Dados da Empresa", new CadastroClienteGUI());
                                }else if(subIndex==1){
                                    FormManager.getInstance().showForm("Configuração do Usuário", new CadastroCarroGUI());
                                }else if(subIndex==2){
                                    FormManager.getInstance().showForm("Configuração de Notificações", new CadastroCarroGUI());
                                }
                            } else if(index==6){
                                if(subIndex==0){
                                    FormManager.getInstance().showForm("Documentação", new CatalogoVeiculos());
                                }else if(subIndex==1){
                                    FormManager.getInstance().showForm("Suporte", new CadastroCarroGUI());
                                }else if(subIndex==2){
                                    FormManager.getInstance().showForm("Sobre", new CadastroCarroGUI());
                                }
                            }
                        }
                    }
                })
                ;

    }

    private SimpleMenu simpleMenu;
}
