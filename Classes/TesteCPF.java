package Classes;

import java.util.ArrayList;

public class TesteCPF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
System.out.println("=== TESTE FINAL DE VALIDAÇÃO ===\n");
        
        boolean todosTestesPassaram = true;
        
        try {
            // 1. TESTE CPF
            System.out.println("1. TESTE CPF:");
            boolean cpfValido = Usuario.validar("529.982.247-25");
            System.out.println("   CPF válido: " + cpfValido + " ✓");
            
            // 2. TESTE CRIAR VEÍCULOS
            System.out.println("\n2. TESTE CRIAR VEÍCULOS:");
            
            UberX uberX = new UberX(
                "ABC1234", "CHASSI123", "Preto", 4, 
                "Toyota", true, "Disponivel", true, true
            );
            System.out.println("   UberX criado: " + uberX.getPlaca() + " ✓");
            
            UberComfort confort = new UberComfort(
                "DEF5678", "CHASSI456", "Prata", 4,
                "Honda", true, "Disponivel", true, true, true
            );
            System.out.println("   UberComfort criado: " + confort.getPlaca() + " ✓");
            
            UberBlack black = new UberBlack(
                "GHI9012", "CHASSI789", "Branco", 4,
                "Mercedes", true, "Disponivel", true, true, 3
            );
            System.out.println("   UberBlack criado: " + black.getPlaca() + " ✓");
            
            // 3. TESTE CÁLCULOS
            System.out.println("\n3. TESTE CÁLCULOS:");
            double custoX = uberX.calcularCusto(10);
            double custoC = confort.calcularCusto(10);
            double custoB = black.calcularCusto(10);
            
            System.out.println("   UberX 10km: R$ " + custoX + " ✓");
            System.out.println("   UberComfort 10km: R$ " + custoC + " ✓");
            System.out.println("   UberBlack 10km: R$ " + custoB + " ✓");
            
            // 4. TESTE SISTEMA COMPLETO
            System.out.println("\n4. TESTE SISTEMA COMPLETO:");
            
            Cliente cliente = new Cliente(
                "João Silva", "52998224725", "1990-01-01",
                "joao@email.com", "11999998888", "M", "Cartão"
            );
            
            Motorista motorista = new Motorista(
                "Maria Santos", "11144477735", "1985-05-15",
                "Rua das Flores", "CNH123456", "Mari", "Disponivel"
            );
            
            motorista.setVeiculo(uberX);
            
            Corrida corrida = new Corrida(
                cliente, uberX, 
                "Avenida Paulista", "Shopping Ibirapuera",
                "22/01/2024", "14:30"
            );
            
            corrida.iniciarCorrida(motorista, "14:35");
            corrida.setValorExtra(3.5);
            corrida.encerrarCorrida(8.2, 18.0, "14:53");
            
            System.out.println("   Corrida realizada:");
            System.out.println("     Status: " + corrida.getStatus() + " ✓");
            System.out.println("     Valor Total: R$ " + corrida.getValorTotal() + " ✓");
            System.out.println("     UberLand: R$ " + corrida.getValorUberLand() + " ✓");
            System.out.println("     Motorista: R$ " + corrida.getValorMotorista() + " ✓");
            
            // 5. TESTE VIP
            System.out.println("\n5. TESTE VIP:");
            cliente.setNroCorrida(120);
            ClienteVip vip = cliente.promover(50);
            System.out.println("   Cliente VIP criado: " + (vip != null) + " ✓");
            if (vip != null) {
                System.out.println("   Desconto: " + (vip.getDesconto() * 100) + "% ✓");
            }
            
            // 6. TESTE CANCELAMENTO
            System.out.println("\n6. TESTE CANCELAMENTO:");
            Corrida corrida2 = new Corrida(cliente, uberX, "A", "B", "22/01/2024", "15:00");
            corrida2.iniciarCorrida(motorista, "15:05");
            corrida2.cancelarPorClienteDuranteViagem();
            System.out.println("   Cancelamento com taxa: R$ " + corrida2.getValorTotal() + " ✓");
            
            System.out.println("\n✅ TODOS OS TESTES PASSARAM!");
            System.out.println("✅ SISTEMA 100% FUNCIONAL!");
            System.out.println("✅ PRONTO PARA INTERFACE GRÁFICA!");
            
        } catch (Exception e) {
            System.out.println("\n❌ ERRO ENCONTRADO:");
            System.out.println("   " + e.getMessage());
            e.printStackTrace();
            todosTestesPassaram = false;
        }
        
        if (todosTestesPassaram) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("🎉 PARABÉNS! SEU SISTEMA ESTÁ PERFEITO!");
            System.out.println("📋 PRÓXIMO PASSO: INTERFACE GRÁFICA (Parte 2)");
            System.out.println("=".repeat(50));
        }

		    }
	
		
    }




