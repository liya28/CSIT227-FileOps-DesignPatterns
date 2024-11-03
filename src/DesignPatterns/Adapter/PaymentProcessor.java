package DesignPatterns.Adapter;

public interface PaymentProcessor {
    void processPayment(double amount);
}

class ModernPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " using Modern Payment Processor.");
    }
}

class LegacyPayment {
    public void executeTransaction(double amount) {
        System.out.println("Processing payment of $" + amount + " using Legacy Payment System.");
    }
}

class LegacyPaymentAdapter implements PaymentProcessor {
    LegacyPayment legacy = new LegacyPayment();

    public void processPayment(double amount) {
        legacy.executeTransaction(amount);
    }
}

class Payment {
    public static void main(String[] args) {
        ModernPaymentProcessor modern = new ModernPaymentProcessor();
        modern.processPayment(100.0);

        PaymentProcessor processor = new LegacyPaymentAdapter();
        processor.processPayment(150.0);
    }
}
