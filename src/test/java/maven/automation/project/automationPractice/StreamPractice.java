package maven.automation.project.automationPractice;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StreamPractice {
	@Test
	public void regular() {
		ArrayList<String> names=new ArrayList<String>();
		names.add("Abhi");
		names.add("Dom");
		names.add("Ali");
		names.add("ozaif");
		names.add("Awais");
		int count=0;
		for (int i=0; i<names.size();i++) {
			String actual=names.get(i);
			if(actual.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	@Test
	public void streamFilter() {
		ArrayList<String> names=new ArrayList<String>();
		names.add("Abhi");
		names.add("Dom");
		names.add("Ali");
		names.add("ozaif");
		names.add("Awais");
		long count = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(count);
		
		long d = Stream.of("Alice", "Bob", "Charlie", "David", "Eve", "Alice")
			    .filter(s -> {
			        s.startsWith("D");
			        return true;
			    })
			    .count();
		System.out.println("d "+d);
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		System.out.println("***************************");
		Stream.of("Alice", "Bob", "Charlie", "David", "Eve", "Alice")
	    .filter(s -> s.endsWith("e"))
	    .map(s -> s.toUpperCase())
	    .forEach(s -> System.out.println(s));
		}
}
