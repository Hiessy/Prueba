package com.web.appointment.test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import com.web.appointment.test.model.Branch;
import com.web.appointment.test.model.Months;
import com.web.appointment.test.model.Provider;
import com.web.appointment.test.model.Service;

public class JavaTimeTest {

	public static void main(String[] args) throws ParseException {

		Map<String, Provider> providers = setupDummieProviders();

		System.out.println("cantidad de provedors: " + providers.size());

		Provider providerTest = providers.get("ProviderID13");

		System.out.println("cantidad de branches para el segundo provedor: " + providerTest.getProvider().size());

		String branchID = "BranchID100";

		Branch branch = providerTest.getProvider().get(branchID);

		System.out.println("cantidad de servicos para el primer Branch: " + branch.getBranchService().size());

		List<Service> services = branch.getBranchService().get("ServiceID10");


			System.out.println("Disponibilidad del profesional: " + "ProfesionalServiceID32");
			for (int i = 0; i < 288; i++)
				System.out.println(services.get(0).getServiceSlots().get("ProfesionalServiceID32").get(2).getSlots()[25][i]);//mes
		
	}

	private static Map<String, Provider> setupDummieProviders() {
		Map<String, Provider> provider = new HashMap<String, Provider>();

		for (int i = 0; i < 200; i++)
			provider.put(("ProviderID" + (i + 12)), new Provider(setupDummieBranches()));

		return provider;

	}

	private static Map<String, Branch> setupDummieBranches() {

		HashMap<String, Branch> branches = new HashMap<String, Branch>();

		int randomAmountOfBranches = new Random().nextInt(3) + 1;
		for (int i = 0; i < randomAmountOfBranches; i++)
			branches.put(("BranchID" + (i + 100)), setupDummieBranch());

		return branches;
	}

	private static Branch setupDummieBranch() {

		Branch branch = new Branch(new HashMap<String, List<Service>>());

		int randomAmountOfServices = new Random().nextInt(2) + 1;
		for (int i = 0; i < randomAmountOfServices; i++) {
			branch.getBranchService().put("ServiceID" + (i + 10), setupDummieService());
		}

		return branch;
	}

	private static List<Service> setupDummieService() {
		List<Service> services = new ArrayList<Service>();

		int randomAmountOfServices = new Random().nextInt(1) + 1;
		for (int i = 0; i < randomAmountOfServices; i++) {
			Service service = new Service(new HashMap<String, List<Months>>());
			service.getServiceSlots().put("ProfesionalServiceID" + (i + 32), getMonths());

			services.add(service);
		}

		return services;
	}

	private static List<Months> getMonths() {
		List<Months> months = new ArrayList<Months>();

		for (int month = 1; month <= 12; month++)
			months.add(new Months(month));

		return months;
	}
}
