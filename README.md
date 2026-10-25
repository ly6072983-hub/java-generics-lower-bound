# Java Generics — Lower Bounded Wildcards

**Student / Author:** Yousef Ayman (يوسف أيمن)

## Description

Java Generics let classes, interfaces, and methods work with different types while checking type safety at compile time. A wildcard (`?`) represents an unknown type. This project demonstrates a lower bounded wildcard using `List<? super Number>`.

## Lower bounded wildcard: `<? super Number>`

The phrase `? super Number` means “some type that is `Number` or a superclass of `Number`.” Therefore, a method accepting `List<? super Number>` can be called with both `List<Number>` and `List<Object>`:

- `Number` is accepted directly.
- `Object` is accepted because `Number` extends `Object`, so `Object` is a supertype of `Number`.

Java generic types are invariant: `List<Object>` is not generally a subtype of `List<Number>`. The wildcard makes this method parameter accept either list safely. It is safe to add `Number` values to either list. When reading values from a `List<? super Number>`, the element type is only guaranteed to be `Object`.

## Example code

```java
public static void addNumbers(List<? super Number> values) {
    values.add(Integer.valueOf(10));
    values.add(Double.valueOf(20.5));
    values.add(Float.valueOf(3.14f));
}
```

`Integer`, `Double`, and `Float` are all subclasses of `Number`, so each can be added. The complete example also prints values and demonstrates calls with both `List<Number>` and `List<Object>` in `src/Main.java` and `src/GenericsExample.java`.

## `extends` and `super` comparison

| Wildcard | Example meaning | Typical use |
| --- | --- | --- |
| `? extends Number` | A list of some unknown subtype of `Number` | Read values as `Number`, such as summing a list. Adding a specific number is not safe in general. |
| `? super Number` | A list of some unknown supertype of `Number` | Add `Number` values, including `Integer`, `Double`, and `Float`. Read values as `Object`. |

In short: `extends` is useful when a method mainly reads values; `super` is useful when it adds values.

## Compile and run

Install a JDK, then open a terminal in the project directory and run:

```bash
javac -encoding UTF-8 -d out src/Main.java src/GenericsExample.java
java -cp out Main
```

## Expected output

```text
10
20.5
3.14
10
20.5
3.14
```

The first group is from the `List<Number>` example; the second is from `List<Object>`.

## Upload to GitHub

### 1. Create a GitHub account

1. Visit [github.com](https://github.com/) and choose **Sign up**.
2. Enter your email address, create a password, choose a username, and complete the verification steps.
3. Verify your email address and sign in.

### 2. Create the repository

1. On GitHub, choose **New repository** (or open the **+** menu and choose **New repository**).
2. Set the repository name to `java-generics-lower-bounded-wildcards`.
3. Choose **Public** or **Private** as required for your assignment.
4. Leave **Add a README file**, **Add .gitignore**, and **Choose a license** unchecked because these files are already in this project.
5. Select **Create repository** and keep the repository page open to copy its URL.

### 3. Upload this project with Git

Install Git if needed, then open a terminal in the project directory. Replace `YOUR-USERNAME` below with your GitHub username. If you selected a different repository visibility, that does not change these commands.

```bash
git init
git add README.md .gitignore src/Main.java src/GenericsExample.java
git commit -m "Add lower bounded wildcard example"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/java-generics-lower-bounded-wildcards.git
git push -u origin main
```

GitHub may prompt you to authenticate; follow its sign-in instructions. After the push finishes, refresh the repository page to see the uploaded files.
