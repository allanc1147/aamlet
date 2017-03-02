package employeeID.client;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

import javax.imageio.ImageIO;

public class ImageStack {

	// Create new Stack
	Stack<BufferedImage> fifo_stack = new Stack<BufferedImage>();

	// If the stack is not empty, then remove the image and return it
	public Object pop() {
		if (!fifo_stack.isEmpty()) {
			return fifo_stack.pop();
		}
		return null;
	}

	// Push the image into the stack, this image will be the first to be popped
	// out, since it is a first in first out data structure
	public void push(BufferedImage image) {
		fifo_stack.push(image);
	}

	public static void main(String[] args) throws IOException {
		// Create an object for the stack
		ImageStack myStack = new ImageStack();

		// Create path for the pictures, this is the part you can change to test
		// out your own pictures
		String img1_path = "F:\\Piyush\\aaSelf_Programming\\Javaa\\aamlet_group\\imageio_pic_google.jpg";
		String img2_path = "F:\\Piyush\\aaSelf_Programming\\Javaa\\aamlet_group\\imageio_pic_tiger.jpg";

		// Now make BufferedImage objects to hold our images
		BufferedImage img1 = ImageIO.read(new File(img1_path));
		BufferedImage img2 = ImageIO.read(new File(img2_path));

		// Test the stack data structure with our images
		myStack.push(img1);
		System.out.println(myStack.pop());
		myStack.push(img2);
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
	}
}